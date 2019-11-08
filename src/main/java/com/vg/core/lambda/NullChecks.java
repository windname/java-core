package com.vg.core.lambda;

import java.util.Optional;
import java.util.stream.Stream;

public class NullChecks {
	public static void main(String[] str) {
		new NullChecks();
	}

	public NullChecks() {
		Optional<String> str = getString();
		str.ifPresent(System.out::println); // just print hello string or do nothing if getString returns null

		Optional<String> nullString = getNull();
		nullString.ifPresent(System.out::println); // do nothing

		String def = getEmpty(null).orElse("Default");
		System.out.println(def);
		System.out.println(getEmpty("not empty").orElse("Default"));
		// very simple Supplier
		System.out.println(getEmpty(null).orElseGet(() -> {return "Default!";}));
		// other option to make chain
		Stream.of(getNull(), getEmpty(null), getString()).filter(Optional::isPresent).map(Optional::get).findFirst().ifPresent(System.out::println);;
		

		// filter result
		getString().filter(s -> isLongString(s)).ifPresent(System.out::println); // nothing due to short string
		getLongString().filter(s -> isLongString(s)).ifPresent(System.out::println);

		Optional<Article> article = getNullArticle();
		article.map(Article::getName).ifPresent(System.out::println); // nothing article is null
		getArticle(null).map(Article::getName).ifPresent(System.out::println); // nothing name is null
		getArticle("my Article").map(Article::getName).ifPresent(System.out::println); // returns article name
		
		String name = getArticle("new article").map(Article::getName).orElse("Default Article");
		System.out.println("article name =" + name);
		name = getNullArticle().map(Article::getName).orElse("Default Article");
		System.out.println("article name =" + name);
		
		if (!getNullArticle().isPresent()) {
			System.out.println("Nothing!");
		}
		
		getMagazine(null, null).flatMap(Magazine::getA).ifPresent(a->print(a)); // do nothing
		getMagazine("magaz", null).flatMap(Magazine::getA).ifPresent(a->print(a)); // do nothing
		getMagazine("magaz", "art").flatMap(Magazine::getA).ifPresent(a->print(a)); // art
//		getMagazine("magaz", "art").map(Magazine::getA).ifPresent(a->print(a)); type is not compatible
		
		Magazine magazine = null;
		Optional<Article> a = Optional.ofNullable(magazine).flatMap(m -> Optional.ofNullable(m.getRawA()));
		a.ifPresent(System.out::print);
		a = Optional.ofNullable(new Magazine()).flatMap(m -> Optional.ofNullable(m.getRawA()));
		a.ifPresent(System.out::print);
		a = Optional.ofNullable(new Magazine(new Article("java8"))).flatMap(m -> Optional.ofNullable(m.getRawA()));
		a.ifPresent(System.out::print);
		
		Buklet b = new Buklet();
		if (b instanceof Magazine) {
			System.out.println("Buklet is magazine!");
		}

	}

	public void print(Article a) {
		System.out.println(a.getName());
	}

	public Optional<String> getNull() {
		return Optional.ofNullable(null);
	}

	public Optional<String> getEmpty(String s) {
		if (s== null) return Optional.empty();
		return Optional.of(s);
	}

	public Optional<String> getString() {
		return Optional.of("Hello");
	}

	public Optional<String> getLongString() {
		return Optional.of("HelloWorld");
	}

	public boolean isLongString(String s) {
		if (s.length() > 5) {
			return true;
		}
		return false;
	}

	public Optional<Article> getNullArticle() {
		return Optional.ofNullable(null);
	}

	public Optional<Article> getArticle(String name) {
		return Optional.ofNullable(new Article(name));
	}
	
	public Optional<Magazine> getMagazine(String magazineName, String articleName) {
		if (magazineName == null) {
			return Optional.empty();
		}
		Magazine m = new Magazine();
		if (articleName != null) {
			m.setA(new Article(articleName));
		}		
		return Optional.of(m);
	}
	

	class Article {
		private String name;

		public Article(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Article [name=" + name + "]";
		}
		
	}
	
	class Magazine {
		
		public Magazine(Article a) {
			this.a = a;
		}
		
		public Magazine() {			
		}

		private Article a;
		
		public Article getRawA() {
			return a;
		}

		public Optional<Article> getA() {
			return Optional.ofNullable(a);
		}

		public void setA(Article a) {
			this.a = a;
		}
	}
	
	class Buklet extends Magazine {
		
	}
}
