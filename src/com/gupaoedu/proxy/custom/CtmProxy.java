package com.gupaoedu.proxy.custom;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Description 自定义代理类
 * @Date 2019/3/16 11:23
 * @Created by rogan.luo
 */
public class CtmProxy {

    static  String ln = "\r\n";
    public static Object newProxyInstance(CtmClassLoader loader,
                                          Class<?>[] interfaces,
                                          CtmInvocationHandler h)
            throws IllegalArgumentException
    {
        //1.生成interfaces的源代码
        String src = gengerateSrc(interfaces);
        System.out.println(src);
        //2.写入到java文件,编译成class文件
        String path = loader.getClass().getResource("").getPath();

        File javaFile = new File(path,"$Proxy0.java");
        try {
            FileWriter fileWriter  = new FileWriter(javaFile);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();
            // 3 编译
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(javaFile);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4 加载 删除
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(CtmInvocationHandler.class);
            javaFile.delete();
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }

    private static String gengerateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.gupaoedu.proxy.custom;").append(ln);
        sb.append("import com.gupaoedu.proxy.jdk.Clue;").append(ln);
        sb.append("import ").append(interfaces[0].getName()).append(";").append(ln);
        sb.append("import java.lang.reflect.*;").append(ln);
        sb.append("public final class $Proxy0 extends CtmProxy implements ").append(interfaces[0].getSimpleName()).append("{").append(ln);

        sb.append("CtmInvocationHandler h;").append(ln);

        sb.append("public $Proxy0(CtmInvocationHandler h){").append(ln);
        sb.append("this.h = h;").append(ln);
        sb.append("}").append(ln);
        for(Method method : interfaces[0].getMethods())
        {
            Parameter[] parameters = method.getParameters();
            String param = "";
            if(parameters != null && parameters.length > 0){
                for(Parameter parameter : parameters)
                {
                    param = param.concat(parameter.getType().getSimpleName() + " " + parameter.getName() + ", ");
                }
                param =  param.substring(0,param.length() - 2);
            }
            sb.append("public final ").append(method.getReturnType()).append(" ").append(method.getName()).append("(").append(param).append(")").append("{").append(ln);
            String paramvalue = "null";
            String paramType = "";
            if(parameters != null && parameters.length > 0){
                paramvalue = "new Object[]{";
                for(Parameter parameter : parameters)
                {
                    paramvalue = paramvalue.concat( parameter.getName() + ", ");
                    paramType = paramType + ","   + parameter.getType().getSimpleName() + ".class";
                }
                paramvalue = paramvalue.substring(0,paramvalue.length() - 2 ).concat("}") ;
            }
            sb.append("try {").append(ln);
            //获取参数类型，paramType
            sb.append("Method method = "+ interfaces[0].getSimpleName()+".class.getMethod(\""+ method.getName() +"\""+paramType+");").append(ln);
            sb.append("return ("+ method.getReturnType() +")h.invoke(this, method , "+ paramvalue +");").append(ln);
            sb.append("}catch(Throwable throwable){").append(ln);

            sb.append("throw new UndeclaredThrowableException(throwable);").append(ln);
            sb.append("}").append(ln);
            sb.append("}").append(ln);

        }
        sb.append("}").append(ln);

        return sb.toString();

    }

}
