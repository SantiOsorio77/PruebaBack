package PruebaEcommerceBack.controller;

import PruebaEcommerceBack.dto.OrderDto;
import PruebaEcommerceBack.service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static PruebaEcommerceBack.constan.PathGeneric.*;

@RestController
@RequestMapping(value = PATH_API_ORDER)
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtoResponse = orderServiceImpl.getAllOrders();
        return new ResponseEntity<>(orderDtoResponse, HttpStatus.OK);
    }

    @GetMapping(value = PATH_ID)
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto orderDtoResponse = orderServiceImpl.getOrderById(id);
        if (orderDtoResponse != null) {
            return new ResponseEntity<>(orderDtoResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto orderDto) {
        OrderDto orderDtoResponse = orderServiceImpl.saveOrder(orderDto);
        return new ResponseEntity<>(orderDtoResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = PATH_ID)
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderServiceImpl.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = PATH_DATE)
    public ResponseEntity<List<OrderDto>> gerOrdersByDate(@RequestParam LocalDateTime fecha) {
        List<OrderDto> orderDtoResponse = orderServiceImpl.gerOrderByDate(fecha);
        return new ResponseEntity<>(orderDtoResponse, HttpStatus.OK);
    }

    @GetMapping(value = PATH_RANGE_DATE)
    public ResponseEntity<List<OrderDto>> getOrdersByRangeDate(
            @RequestParam LocalDateTime fechaInicio,
            @RequestParam LocalDateTime fechaFin) {
        List<OrderDto> orderDtoResponse = orderServiceImpl.getOrdersByRangeDate(fechaInicio, fechaFin);
        return new ResponseEntity<>(orderDtoResponse, HttpStatus.OK);
    }

    @GetMapping(value = PATH_PRODUCT_PRODUCT_ID)
    public ResponseEntity<List<OrderDto>> getOrdersByProduct(@PathVariable Long productoId) {
        List<OrderDto> orderDtoResponse = orderServiceImpl.getOrdersByProduct(productoId);
        return new ResponseEntity<>(orderDtoResponse, HttpStatus.OK);
    }

    @GetMapping(value = PATH_QUANTITY)
    public ResponseEntity<List<OrderDto>> getOrdesQuantityGreater(@RequestParam Integer cantidadMinima) {
        List<OrderDto> orderDtoResponse = orderServiceImpl.getOrdesQuantityGreater(cantidadMinima);
        return new ResponseEntity<>(orderDtoResponse, HttpStatus.OK);
    }

    @GetMapping(value = PATH_TOTAL_SALES)
    public ResponseEntity<Double> getTotalSalesDateRange(
            @RequestParam LocalDateTime fechaInicio,
            @RequestParam LocalDateTime fechaFin) {
        Double totalVentas = orderServiceImpl.getTotalSalesDateRange(fechaInicio, fechaFin);
        return new ResponseEntity<>(totalVentas, HttpStatus.OK);
    }
}
