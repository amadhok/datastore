package unbxd.data;

public class Product{

	private final String productId;
	private final String productName;
	private final String genre;
	private final String artist;

	Product(String productId,String productName,String genre,String artist){
		
		this.productId= productId;
		this.productName=productName;
		this.genre=genre;
		this.artist=artist;
	}
	
	public String getProductId(){
		return this.productId;
	}
	
	public String getProductName(){
		return this.productName;
	}
	
	public String getGenre(){
		return this.genre;
	}
	
	public String getArtist(){
		return this.artist;
	}

}