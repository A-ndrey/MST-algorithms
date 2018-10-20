package reading_verilog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VerilogReader {

    private Scanner scanner;
    private File file;
    private Map<String, List<String>> connections;
    private Set<String> nodes;
    private static VerilogReader instance;

    public static VerilogReader getInstance(File file) throws FileNotFoundException {
        if (instance == null){
            instance = new VerilogReader(file);
        }
        return instance;
    }

    private VerilogReader(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        connections = new HashMap<>();
        nodes = new HashSet<>();
        read();
    }

    public Map<String, List<String>> getConnections(){
        return connections;
    }

    public Set<String> getNodes(){
        return nodes;
    }

    private void read(){
        String operator;
        while (scanner.hasNext()) {
            operator = scanner.next();
            switch (operator) {
                case "//":
                    scanner.nextLine();
                case "module":
                case "input":
                case "output":
                    while(scanner.hasNext() && !scanner.nextLine().endsWith(";"));
                    break;
                case "wire":
                    String line;
                    do{
                        line = scanner.nextLine();
                        String[] wires = line.trim().replace(";", "").split(",");
                        for(String wire : wires){
                            connections.put(wire, new ArrayList<>());
                        }
                    }while(scanner.hasNext() && !line.endsWith(";"));
                    break;
                case "endmodule":
                    return;
                default:
                    String element = scanner.next();
                    nodes.add(element);
                    String[] arguments = scanner.nextLine().trim().replaceAll("[();]", "").split(", ");
                    for (String argument : arguments){
                        if (connections.containsKey(argument)){
                            connections.get(argument).add(element);
                        }
                    }
            }
        }
    }

    public void print() {
        System.out.println(connections);
    }



    public void close(){
        scanner.close();
    }

}
