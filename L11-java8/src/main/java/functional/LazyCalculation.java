package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LazyCalculation {

    public static void main(String[] args){
        var item = new LazyCalculation();
        item.doSmth( item::veryHeavyDataRequest );
    }

    public void doSmth( Supplier<List<String>> supplier ){
        boolean variant = false;
        if (variant){
            var data = supplier.get();
            // что делаем с data
        } else {
             // иначе data нам не нужны
        }
    }

    public List<String> veryHeavyDataRequest(){
        // Очень очень тяжелый...

        return new ArrayList<>();
    }
}
