package ie.atu.week2_refresher;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/products/")
public class ProductController {
    private final List<Product> products = new ArrayList<>();

    @GetMapping("get")
    public List<Product> getAllProducts() {
        return products;
    }

    @PostMapping("add")
    public ResponseEntity<String> addProduct(@RequestBody Product newProduct) {
        products.add(newProduct);
        return new ResponseEntity<>("Product successfully created\n" + newProduct, HttpStatus.CREATED);
    }
}
