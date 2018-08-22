/*
 * Copyright (c) 2018 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.materialfilemanager.filesystem;

public interface LocalFileOperationStrategies {

    LocalFileOperationStrategy JAVA_FILE_STRATEGY = new LocalFileOperationStrategy() {

        @Override
        public void createDirectory(LocalFile file) throws FileSystemException {
            JavaFile.createDirectory(file.makeJavaFile());
        }

        @Override
        public void createFile(LocalFile file) throws FileSystemException {
            JavaFile.createFile(file.makeJavaFile());
        }

        @Override
        public void delete(LocalFile file) throws FileSystemException {
            JavaFile.delete(file.makeJavaFile());
        }

        @Override
        public void rename(LocalFile file, String newName) throws FileSystemException {
            JavaFile.rename(file.makeJavaFile(), newName);
        }
    };

    LocalFileOperationStrategy ANDROID_OS_STRATEGY = new LocalFileOperationStrategy() {

        @Override
        public void createDirectory(LocalFile file) throws FileSystemException {
            AndroidOs.createDirectory(file.getPath());
        }

        @Override
        public void createFile(LocalFile file) throws FileSystemException {
            AndroidOs.createFile(file.getPath());
        }

        @Override
        public void delete(LocalFile file) throws FileSystemException {
            AndroidOs.delete(file.getPath());
        }

        @Override
        public void rename(LocalFile file, String newName) throws FileSystemException {
            AndroidOs.rename(file.getPath(), newName);
        }
    };
}
