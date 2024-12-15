package module11.assignment11;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {
    public static void main(String[] args) {
        String json = "{\"name\":\"Agam\",\"age\":26,\"skills\":[\"Java\",\"Spring\",\"JSON\"]}";

        try {
            ObjectMapper mapper = new ObjectMapper();
            Developer developer = mapper.readValue(json, Developer.class);

            System.out.println("Name: " + developer.getName());
            System.out.println("Age: " + developer.getAge());
            System.out.println("Skills: " + developer.getSkills());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Developer {
    private String name;
    private int age;
    private List<String> skills;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }
}
