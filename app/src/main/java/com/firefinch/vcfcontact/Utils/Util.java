package com.firefinch.vcfcontact.Utils;

import android.util.Log;

import com.firefinch.vcfcontact.models.VFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Util {
    public static Iterator<File> walk(File root, String[] extensions) {
        Log.d("Util", root.getAbsolutePath());
        IOFileFilter filter = new SuffixFileFilter(extensions, IOCase.INSENSITIVE);
        return FileUtils.iterateFiles(root, filter, DirectoryFileFilter.DIRECTORY);
    }
    public static List<VFile> walkVFiles(File root) {
        String[] extensions = new String[]{"vcf"};
        Iterator<File> it = walk(root, extensions);
        List<VFile> result = new ArrayList<>();
//        result.add(new VFile(root));
        for (Iterator<File> it1 = it; it1.hasNext(); ) {
            File file = it1.next();
            result.add(new VFile(file));
            Log.d("DEF", file.getName());
        }
        Log.d("ABC", "" + result.size());
        return result;
    }
}
