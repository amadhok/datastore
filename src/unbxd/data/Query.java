package unbxd.data;

import java.util.Date;

public class Query{
	
	private final String query;
	private final String productId;
	private final Date timeStamp;
	
	Query(String query,String productId,Date timeStamp){
		this.query=query;
		this.productId=productId;
		this.timeStamp=timeStamp;
	}

	public String getQuery(){
		return this.query;
	}
	
	public String getProductId(){
		return this.productId;
	}
	
	public Date getTimeStamp(){
		return this.timeStamp;
	}

}
