package com.firefinch.vcfcontact.Utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Filewalker {
    /*public ArrayList<File> walk(File root, String[] extensions) {
        ArrayList<File> files = new ArrayList<>();
        walkHelper(root, extension, files);
        return files;
        IOFileFilter filter =  new SuffixFileFilter(extensions, IOCase.INSENSITIVE);
        FileUtils.listFiles(root, filter, true, DirectoryFileFilter.DIRECTORY);
    }
    private void walkHelper(File root, String extention, ArrayList<File> filesArrayList) {

        File[] list = root.listFiles();

        for (File f : list) {
            if (f.isDirectory()) {
                walkHelper(f, extention, filesArrayList);
            }
            else if (f.getName().toLowerCase().endsWith("vcf")){
                filesArrayList.add(f.getAbsoluteFile());
            }
        }
    }*/
}
