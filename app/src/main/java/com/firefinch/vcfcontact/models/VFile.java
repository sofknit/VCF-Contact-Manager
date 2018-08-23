package com.firefinch.vcfcontact.models;

import android.support.annotation.NonNull;

import java.io.File;
import java.net.URI;

public class VFile extends File{
    public VFile(@NonNull String pathname) {
        super(pathname);
    }

    public VFile(String parent, @NonNull String child) {
        super(parent, child);
    }

    public VFile(File parent, @NonNull String child) {
        super(parent, child);
    }

    public VFile(@NonNull URI uri) {
        super(uri);
    }
    public VFile(File file) {
        super(file, "");
    }
}
