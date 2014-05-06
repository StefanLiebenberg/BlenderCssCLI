package slieb.blendercss.cli;

import com.google.inject.Injector;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import slieb.blendercss.Blender;
import slieb.blendercss.Loader;

import java.io.IOException;

public class CommandLineRunner {
    public static void main(String[] args) throws IOException, CmdLineException {
        CommandLineOptions options = new CommandLineOptions();
        final CmdLineParser cmdLineParser = new CmdLineParser(options);
        cmdLineParser.parseArgument(args);
        Injector injector = Loader.getInjector(options.getWorkingDirectory());
        Blender blender = injector.getInstance(Blender.class);
        blender.compile(
                options.getInputFiles(),
                options.getOutputFile(),
                options.getBlendOptions());
    }
}
