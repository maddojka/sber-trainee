public class City {
    private String name;
    private String region;
    private String district;
    private long population;
    private String foundation;

    public City(String name, String region, String district, long population, String foundation) {
        if ("".equals(name)) throw new IllegalArgumentException("Название города не может быть пустой строкой");
        if ("".equals(region)) throw new IllegalArgumentException("Регион не может быть пустой строкой");
        if ("".equals(district))
            throw new IllegalArgumentException("Федеральный округ не может быть пустой строкой");
        if (population <= 0)
            throw new IllegalArgumentException("Количество жителей города не может быть меньше или равным нулю");
        if ("".equals(foundation)) throw new IllegalArgumentException("Год основания не может быть пустой строкой");
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}
