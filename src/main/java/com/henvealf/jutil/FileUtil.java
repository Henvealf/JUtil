package com.henvealf.jutil;

import java.io.File;
import java.util.*;

/**
 * 文件工具
 * Created by hongliang.yin/Henvealf on 2017/7/20.
 */
public class FileUtil {

    /**
     * 列出目录下的所有文件,不包括目录
     * 如果给的就是文件，就返回一个只包含该文件的list
     * @param file
     * @return
     */
    public static List<File> getDirFileList(File file){
        List<File> fileList = new ArrayList<>();


        if (file.isDirectory()){
            Stack<File> nowRootDirStack = new Stack<>();
            nowRootDirStack.push(file);
            while(true) {

                if (nowRootDirStack.isEmpty())
                    return fileList;

                File nowDir = nowRootDirStack.pop();
                File[] nowFiles = nowDir.listFiles();

                if(nowFiles == null || nowFiles.length == 0)
                    continue;

                for (File nowFile : nowFiles) {
                    if(nowFile.isFile())
                        fileList.add(nowFile);
                    else if(nowFile.isDirectory()){
                        nowRootDirStack.push(nowFile);
                    }
                }
            }
        } else {
            fileList.add(file);
        }
        return fileList;
    }


}
