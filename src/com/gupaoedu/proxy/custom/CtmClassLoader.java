package com.gupaoedu.proxy.custom;

import java.io.*;

/**
 * @Description 自定义类加载器
 * @Date 2019/3/16 11:25
 * @Created by rogan.luo
 */
public class CtmClassLoader extends ClassLoader {

    private File baseFile;

    public CtmClassLoader()
    {
        String baseDir = CtmClassLoader.class.getResource("").getPath();
//   toString     "baseDirfile:/F:/workspace/hello/hello-server/target/classes/com/to8to/hello/jdk/ctm/"
        System.out.println("baseDir "+baseDir);
        baseFile = new File(baseDir);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String className = CtmClassLoader.class.getPackage().getName() + "." + name;
        System.out.println( "加载的className" + className);
        File classFile = new File(baseFile,name.replaceAll("\\.","/") + ".class");
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(classFile);
            out = new ByteArrayOutputStream();
            byte [] buff = new byte[1024];
            int len;
            while (-1 != (len = in.read(buff)))
            {
                out.write(buff,0, len);
            }
           /*int b;
           while (-1 != (b = in.read()))
           {
               out.write(b);
           }*/
            return defineClass(className,out.toByteArray(),0,out.size());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null){
                try {
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        return null;

    }

}
