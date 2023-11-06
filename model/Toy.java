package IntermediateHWToyShop.model;

public class Toy implements Comparable<Toy> {
    private final int id;
    private final String name;
    private int weight;
    private int dropFrequency;

    public Toy(int id, String name, int weight, int dropFrequency) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.dropFrequency = dropFrequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int amount) {
        this.weight = amount;
    }

    public int getDropFrequency() {
        return dropFrequency;
    }

    @Override
    public String toString() {
        return "\nИгрушка " +
                "№ " + id +
                ", '" + name + '\'' +
                ", вес: " + weight +
                ", шанс выпадения: " + dropFrequency + " %";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + weight;
        result = prime * result + dropFrequency;
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
        Toy other = (Toy) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (weight != other.weight)
            return false;
        if (dropFrequency != other.dropFrequency)
            return false;
        return true;
    }

    @Override
    public int compareTo(Toy o) {
         if (this.id > o.id) return  1;
        else if (this.id < o.id) return  -1;
        return 0;
    }
}

