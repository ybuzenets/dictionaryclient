package dev.buzenets.dictionary.client.cli;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import lombok.Getter;

import java.util.ArrayList;

@Parameters(separators = "=")
public class Args {
    @Parameter(names = {"--address", "--addr", "-a"}, description = "IP or Hostname to bind server")
    @Getter
    private String address = "127.0.0.1";

    @Parameter(names = {"--port", "-p"}, description = "Port number")
    @Getter
    private Integer port = 9000;

    @Parameter(names = {"--command", "-c"}, description = "Command", required = true)
    @Getter
    private String command = null;

    @Parameter(names = {"--args"}, description = "Arguments", variableArity = true, required = true)
    @Getter
    private ArrayList<String> args = new ArrayList<>();
}
