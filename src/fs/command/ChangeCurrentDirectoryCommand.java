/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fs.command;

import fs.App;
import fs.Disk;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class ChangeCurrentDirectoryCommand extends Command{
    
    public static final String COMMAND = "CambiarDIR";

    @Override
    public void execute(String[] args) {
        try 
        {
            if (args.length != 2)
            {
                reportSyntaxError();
                return;
            }
            
            App app = App.getInstance();
            Disk disk = app.getDisk();
            String path = args[1];
            
            disk.changeCurrentDirectory(path);
            
        } 
        catch (FileNotFoundException | NotDirectoryException ex) {
            Logger.getLogger(ChangeCurrentDirectoryCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getName() {
        return COMMAND;
    }

    @Override
    protected String getDescription() 
    {
        return "Changes the current directory to the specified path.";   
    }

    @Override
    protected String getSyntax() {
       return getName() + " PATH...";
    }
    
}
