import tester.Tester;

// to represent a pet owner
class Person {
	String name;
	IPet pet;
	int age;
	
	Person(String name, IPet pet, int age) {
			this.name = name;
			this.pet = pet;
			this.age = age;
	}
// TEMPLATE
	/* 
	 *  this.age -- int
	 *  Methods:
	 *  	this.isOlder(Person other) -- boolean
	 *  
	 *  -> boolean 
	 *  returns true if this person is older than the other person, otherwise false
	 */
	boolean isOlder(Person other) {
		if(this.age > other.age) {
			return true;
		}else {
			return false;
		}
	}
}
// to represent a pet
interface IPet {}
// to represent a pet cat
class Cat implements IPet {
	String name;
	String kind;
	boolean longhaired;
	Cat(String name, String kind, boolean longhaired) {
		this.name = name;
		this.kind = kind;
		this.longhaired = longhaired;
	}
}

// to represent a pet dog
class Dog implements IPet {
	String name;
	String kind;
	boolean male;	
	
	Dog(String name, String kind, boolean male) {
		this.name = name;
		this.kind = kind;
		this.male = male;
	} 
}

class ExamplesIPet{
	ExamplesIPet() {}
	
		IPet whitey = new Dog ("Whitey", "Aspin", false);
		IPet blacky = new Cat ("blacky", "Persian", false);
		IPet browny = new Dog ("Browny", "Aspin", true);
		IPet pinky = new Cat ("Pinky", "Birman", true);
		
		Person nigell = new Person ("Nigell", whitey, 15);
		Person jezza = new Person ("Jezza", blacky, 16);
		Person candace = new Person ("Candace", browny, 17);
		Person allysa = new Person ("Allysa", pinky, 18);

		boolean testOlder(Tester t) {
			return
					t.checkExpect(nigell.isOlder(jezza), false) &&
					t.checkExpect(candace.isOlder(nigell), true) &&
					t.checkExpect(allysa.isOlder(candace), true) &&
					t.checkExpect(allysa.isOlder(nigell), true) &&
					t.checkExpect(allysa.isOlder(jezza), true) &&
					t.checkExpect(nigell.isOlder(candace), false) &&
					t.checkExpect(nigell.isOlder(allysa), false);
		}
}



		
