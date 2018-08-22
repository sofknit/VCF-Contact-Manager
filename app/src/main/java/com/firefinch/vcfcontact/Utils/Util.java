package com.firefinch.vcfcontact.Utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Iterator;

public class Util {
    public static Iterator walk(File root, String[] extensions) {
        IOFileFilter filter = new SuffixFileFilter(extensions, IOCase.INSENSITIVE);
        return FileUtils.iterateFiles(root, filter, DirectoryFileFilter.DIRECTORY);
    }
}
