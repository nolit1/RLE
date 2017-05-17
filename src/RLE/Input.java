package RLE;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class Input {

//    boolean a = false;
//    boolean b = false;
//    boolean c = false;

    @Option(name = "-z", metaVar = "encode", forbids = {"-u"}, usage = "Input file encoding")
    private boolean inputEncoding;

    @Option(name = "-u", metaVar = "decode", forbids = {"-z"}, usage = "Output file decoding")
    private boolean outputEncoding;

    @Argument(required = true, metaVar = "InputName", usage = "Input file name")
    private String inputFileName;

    @Option(name = "-out", metaVar = "OutputName", usage = "Output file name")
    private String outputFileName;

    public Boolean getInputEncoding() {
        return inputEncoding;
    }

    public Boolean getOutputEncoding() {

        return outputEncoding;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public String getOutputFileName() {
        if (outputFileName == null) {
            outputFileName = inputFileName + ".rle";
        }
        return outputFileName;
    }
}