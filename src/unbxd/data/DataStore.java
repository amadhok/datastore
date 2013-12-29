package unbxd.data;

import java.util.HashMap;
import java.util.HashSet;

public class DataStore {
    public DataStore() {
        super();
    }
    
//    private final int MAX_Product_List_Size = 10000;
//    private final int MAX_Query_List_Size = 10000;

    HashMap<String, HashSet<String>> queryMap =
        new HashMap<String, HashSet<String>>();
    HashMap<String, HashSet<String>> artistMap =
        new HashMap<String, HashSet<String>>();
    HashMap<String, Product> productList = new HashMap<String, Product>();
    HashMap<String, Query> queryList = new HashMap<String, Query>();

    public void addProduct(Product prdt) {
        productList.put(prdt.getProductId(), prdt);
    }

    private void addQueryToStore(Query q) {
        //TODO Do I need to validate that productId for this query is in productList?
        queryList.put(q.getQuery(), q);
    }

    public boolean addQuery(Query q) {
        boolean added = false;
        boolean qAdded = false;
        
        addQueryToStore(q);

        if (!queryMap.containsKey(q.getQuery())) {
            HashSet<String> pSet = new HashSet<String>();
            added = pSet.add(q.getProductId());
        } else {
            added = queryMap.get(q.getQuery()).add(q.getProductId());
        }

        Product prdt = getProduct(q.getProductId());

        if (!artistMap.containsKey(prdt.getArtist())) {
            HashSet<String> qSet = new HashSet<String>();
            qAdded = qSet.add(q.getQuery());
        } else {
            qAdded = artistMap.get(prdt.getArtist()).add(q.getQuery());
        }

        return added || qAdded;
    }

    public Product[] getProductsForQuery(Query q) {
        HashSet<String> productIds = queryMap.get(q.getQuery());
        Product[] products=new Product[productIds.size()];
        int i=0;
        for(String pId:productIds ){
                products[i++]=getProduct(pId);
            }
        return products;
    }

    public Query[] getQueryForArtist(String artist) {       
        HashSet<String> queriesIds = queryMap.get(artist);
        Query[] queries=new Query[queriesIds.size()];
        int i=0;
        for(String qId:queriesIds ){
                queries[i++]=queryList.get(qId);
            }
        return queries;        
    }

    private Product getProduct(String productId) {
        return productList.get(productId);
    }
}
