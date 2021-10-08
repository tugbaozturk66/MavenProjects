package day05;

import org.junit.Test;

public class C01_Notasyon {
    // javadaki gibi selenium da da belirli islevleri yapan method olusturabiliriz
    //ancak bu methodlar cagirilmadikca calismazlar.

    public void ilkTestMethodu(){
        System.out.println("Ilk test methodumuz");
    }
    //Junit ile notasyon kullanarak siradan methodlari test methoduna donusturebiliriz
    //bir test method u bagimsiz olarak calisabilen test yapmamiza imkan verir.
    // @Test notasyonu sayesinde main method mecburiyeti ortadan kalkar
    @Test
    public void notasyonluIlkTestMethodu(){
        System.out.println("notasyonlu ilk test methodumuz");
    }
}
