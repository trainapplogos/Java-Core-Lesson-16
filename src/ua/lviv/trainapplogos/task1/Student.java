package ua.lviv.trainapplogos.task1;

public class Student extends Person implements SessionStages  {
	public String name;
	public int age;
	private int height;
	private int yearOfStudy;
	
	public Student() {}
	
	public Student(String name, int age, int height, int yearOfStudy) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.yearOfStudy = yearOfStudy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + yearOfStudy;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearOfStudy != other.yearOfStudy)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", height=" + height + ", yearOfStudy=" + yearOfStudy + "]";
	} 
	
	public int SessionStart(int yearOfStudy) { return 0; }
	
	public int SessionEnd(int yearOfStudy) { return 0; }

	public void BreakSession() {}
	
	private void OutputGritting(int yearOfStudy) {
		System.out.println("!!!Hello student of " + yearOfStudy + "!");
	}


}

