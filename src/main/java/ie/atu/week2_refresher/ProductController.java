package ie.atu.week2_refresher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products/")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("get")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("add")
    public ResponseEntity<String> addProduct(@RequestBody Product new_product) {
        productService.addProduct(new_product);
        return new ResponseEntity<>("Product successfully created\n", HttpStatus.CREATED);
    }
}
