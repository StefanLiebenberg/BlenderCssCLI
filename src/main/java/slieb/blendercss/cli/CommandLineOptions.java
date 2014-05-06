package slieb.blendercss.cli;


import com.google.common.collect.ImmutableList;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import slieb.blendercss.BlendOptions;

import java.io.File;

public class CommandLineOptions {

    private String imagePath, outputPath;

    private File outputCssRenameMap, workingDirectory, outputFile;

    private Boolean shouldCompile, shouldDebug;

    private ImmutableList.Builder<File> inputFilesBuilder =
            new ImmutableList.Builder<File>();

    @Option(name = "--imagePath",
            usage = "The http path to where images are")
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    @Option(name = "--outputPath",
            usage = "The http path to where images are")
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    @Option(name = "--outputCssRenameMap",
            usage = "The javascript css rename map")
    public void setOutputCssRenameMap(File outputCssRenameMap) {
        this.outputCssRenameMap = outputCssRenameMap;
    }

    @Option(name = "--workingDirectory",
            usage = "The working directory.")
    public void setWorkingDirectory(File workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    @Option(name = "--outputFile",
            aliases = "-O",
            usage = "The working directory.")
    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    @Option(name = "--shouldCompile",
            usage = "This project should be compiled.")
    public void shouldCompile(Boolean value) {
        this.shouldCompile = value;
    }

    @Option(name = "--shouldDebug",
            usage = "This project should build for debug")
    public void setShouldDebug(Boolean shouldDebug) {
        this.shouldDebug = shouldDebug;
    }

    @Argument(multiValued = true)
    public void setInputFiles(File[] inputFiles) {
        for (File file : inputFiles) {
            this.inputFilesBuilder.add(file);
        }
    }

    public BlendOptions getBlendOptions() {
        return new BlendOptions.Builder()
                .setImagesPath(imagePath)
                .setOutputCssRenameMap(outputCssRenameMap)
                .setOutputPath(outputPath)
                .setShouldCompile(shouldCompile)
                .setShouldDebug(shouldDebug)
                .build();
    }

    public File getWorkingDirectory() {
        return workingDirectory;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public ImmutableList<File> getInputFiles() {
        return inputFilesBuilder.build();
    }
}
