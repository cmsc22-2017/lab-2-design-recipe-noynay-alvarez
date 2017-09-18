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
  *   this.isOlder(Person other) -- boolean
  */
  // -> boolean 
  // returns true if this person is older than the other person, otherwise false
  boolean isOlder(Person other) {
    if(this.age > other.age) {
      return true;
    }else {
      return false;
    }
  }
 
 /*
  * TEMPLATE
  *  Fields:
  *   ...this.name...  --String
  *   ...this.pet...  --IPet
  *   ...this.aga...   --int
  * 
  *  Methods:
  *   Person perish()  --Person
  */  
 
 // IPet -> Person
 // Returns a Person with no pet or the pet has perished.
  Person perish(IPet empty){
    return new Person(this.name,empty,this.age);
  }
}


// to represent a pet
interface IPet {
  boolean sameNamePet(String petName);
}

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
 
   /*
  * TEMPLATE
  *  Fields:
  *   ...petName...    --String
  *   ...this name...  --String
  * 
  *  Methods:
  *   
  */  
  //-> boolean
  // Return true if this Pet has same name with that pet.
  public boolean sameNamePet(String petName){
    return this.name.equals(petName);
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
 
  //-> boolean
 // Return true if this Pet has same name with that pet.
  public boolean sameNamePet(String petName){
    return this.name.equals(petName);
  }
}

class NoPet implements IPet{ 
  NoPet(){}
  @Override
  public boolean sameNamePet(String petName) {
    // TODO Auto-generated method stub
    return false;
  }
}

class ExamplesIPet{
  ExamplesIPet() {}
 
    IPet whitey = new Dog ("Whitey", "Aspin", false);
    IPet blacky = new Cat ("blacky", "Persian", false);
    IPet browny = new Dog ("Browny", "Aspin", true);
    IPet pinky = new Cat ("Pinky", "Birman", true);
    IPet empty = new NoPet();
  
      Person nigell = new Person ("Nigell", whitey, 15);
      Person jezza = new Person ("Jezza", blacky, 16);
      Person candace = new Person ("Candace", browny, 17);
      Person allysa = new Person ("Allysa", pinky, 18);
  
      Person tim = new Person("Tim",empty,18);
      Person debs = new Person("Deboy",empty,19);
  
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
  
   boolean testsameNamePet(Tester t){
     return
       t.checkExpect(browny.sameNamePet("Whitey"),false) &&
       t.checkExpect(whitey.sameNamePet("Whitey"), true) &&
       t.checkExpect(blacky.sameNamePet("Pinky"), false) &&
       t.checkExpect(pinky.sameNamePet("Pinky"), true);
   }
  
   boolean testPerish(Tester t){
     return
       t.checkExpect(this.tim.perish(empty),tim)&&
       t.checkExpect(this.debs.perish(empty),debs);
   }
}
