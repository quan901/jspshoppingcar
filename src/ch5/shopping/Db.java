package ch5.shopping;

import java.util.LinkedHashMap;
import java.util.Map;

public class Db {

	private static Map<String,Book> map=new LinkedHashMap<String,Book>();
	
	static {
		map.put("1", new Book("1","《spring 实战1》","沃尔斯（Craig Walls）",66));
		map.put("2", new Book("2","《spring 实战2》","沃尔斯（Craig Walls）",66));
		map.put("3", new Book("3","《spring 实战3》","沃尔斯（Craig Walls）",66));
		map.put("4", new Book("4","《spring 实战4》","沃尔斯（Craig Walls）",66));
		map.put("5", new Book("5","《spring 实战5》","沃尔斯（Craig Walls）",66));
	}
	
	public static Map getAll() {
		return map;
	}
	
	public static void main(String[] args) {
		Map<String,Book> map=Db.getAll();
		for(Map.Entry<String, Book> entry:map.entrySet()) {
			Book book=entry.getValue();
			System.out.println(book.getName()+"<a href='BuyServlet? id="+book.getId()+"'target='_blank'>购买</a><br/>");
		}

	}

}
