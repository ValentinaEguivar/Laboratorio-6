public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        
        store.addProduct(new Electronic("Laptop", 1000.0));
        store.addProduct(new Electronic("Smartphone", 500.0));
        
        store.addProduct(new Accessory("Funda", 20.0));
        store.addProduct(new Accessory("Audifonos", 150.0));
        store.addProduct(new Accessory("Cargador", 40.0));

        System.out.println("Descuento 10%");
        Discountable tenPercentDiscount = product -> product.getPrice() * 0.9;
        store.applyDiscount(tenPercentDiscount);

        System.out.println("\n Descuento 50 dolares");
        Discountable fiftyDollarsDiscount = product -> product.getPrice() - 50.0;
        store.applyDiscount(fiftyDollarsDiscount);

        System.out.println("\n Descuento combinado");
        Discountable descuentoCombinado = product -> (product.getPrice() * 0.8) - 5.0;
        store.applyDiscount(descuentoCombinado);

        System.out.println("\n Descuento Condicional");
        Discountable descuentoCondicional = product -> {
            if (product.getPrice() > 100.0) {
                return product.getPrice() * 0.7;
            } else {
                return product.getPrice();
            }
        };
        store.applyDiscount(descuentoCondicional);
    }
}