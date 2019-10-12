public class TextDecoder{
	private final String path = "input\\";
    private String fullPath;
    private String keyFullPath;

	public TextDecoder(String filename){
        this.fullPath = path + filename;
        this.keyFullPath = path + "key" + filename;
	}

    public boolean Start(){

    }
    
}