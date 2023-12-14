package com.salex.creational.builder;

/**
 * Builder (Строитель) - порождающий шаблон проектирования.
 * Разделяет создание сложного объекта и инициализацию его состояния так,
 * что одинаковый процесс построения может создать объекты с разным состоянием.
 * Избавляет от перегрузки конструкторов. Особенно удобно, если комбинаций параметров
 * в конструкторе может быть большое множество.
 */
public class Person {

    private String name;
    private int age;
    private Sex sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {

        private final Person person;

        public Builder() {
            person = new Person();
        }

        public Builder name(String name) {
            person.setName(name);
            return this;
        }

        public Builder age(int age) {
            person.setAge(age);
            return this;
        }

        public Builder sex(Sex sex) {
            person.setSex(sex);
            return this;
        }

        public Person build() {
            return person;
        }
    }
}
