import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * List all filles.
     */
    public void listAllFilles()
    {
        // Imprime por pantalla todos los archivos en la coleccion
        for (String fileName : files)
        {
            // Sumamos uno a la posicion para que el listado comienze por 1
            int listPosition = files.indexOf(fileName);
            System.out.println ((listPosition +1)+ ".- " +  files.get(listPosition));
        }
    }
    
    /**
     * List files with the String as parameter.
     */
    public void listMatching(String searchString)
    {
        boolean validName = false;
        // Recorre la coleccion, si coincide lo miprime por pantalla
        for (String fileName : files)
        {
            if (fileName.contains(searchString))
            {
                System.out.println (fileName);
                validName = true;
            }
        }
        if (!(validName))
        {
            System.out.println("No se han encontrado archivos con ese nombre");
        }
    }
    
    /**
     * Play the few seconds of all the files from an artist given as parameter.
     */
    public void playSampleOf(String artistName)
    {
        for (String fileName : files)
        {
            if (fileName.contains(artistName))
            {
                player.playSample(fileName);
            }
        }
    }

}
