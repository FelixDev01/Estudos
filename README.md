### Sobre o projeto

## Este projeto implementa um sistema para calcular o valor total de um pedido, considerando:

✔ valor básico

✔ desconto em %

✔ frete calculado automaticamente

# A aplicação foi desenvolvida com Spring Boot, aplicando injeção de dependência e separação de responsabilidades em serviços, conforme exigido no desafio.

## Regras de frete
Valor do pedido (basic)	Frete aplicado
Menor que R$ 100,00	R$ 20,00
Entre R$ 100,00 e R$ 200,00	R$ 12,00
Igual ou maior que R$ 200,00	Grátis (0,00)
🧩 Estrutura do código
Order.java
public class Order {

    Integer code;
    Double basic;
    Double discount;
}

ShippingService.java
@Service
public class ShippingService {

    double shipment(Order order){

        if(order.getBasic() < 100){
            return 20.00;
        }
        else if (order.getBasic() >= 100 && order.getBasic() <= 200) {
            return 12.00;
        }
        else {
            return 0.0;
        }
    }
}

OrderService.java
@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    public double total(Order order){

        double discountValue = order.getBasic() * order.getDiscount() / 100;
        double total = order.getBasic() - discountValue + shippingService.shipment(order);
        return total;
    }
}

##  Como executar
mvn spring-boot:run


Após rodar a aplicação, a saída será exibida diretamente no console (log).

## Exemplo de funcionamento

Para um pedido:

Código: 1034
Valor base: 150.00
Desconto: 20%


Resultado esperado:

Pedido código 1034
Valor total: R$ 132.00

## Conceitos aplicados

✔ Injeção de Dependência (@Autowired)

✔ Componentização de serviços (@Service)

✔ Regra de negócio isolada em classes separadas

✔ Código limpo, legível e flexível
