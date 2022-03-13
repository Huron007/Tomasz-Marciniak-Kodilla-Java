package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private InformationService informationService;
    private OrderRepository orderRepository;
    private ProductOrderService productOrderService;

    public OrderProcessor(final MailService mailService, final OrderRepository orderRepository, final ProductOrderService productOrderService){
        this.informationService = mailService;
        this.orderRepository = orderRepository;
        this.productOrderService = productOrderService;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = productOrderService.process(orderRequest.getOrder());

        if(isOrdered){
            informationService.inform(orderRequest.getOrder());
            orderRepository.addToRepository(orderRequest.getOrder());
            return new OrderDto(orderRequest.getOrder().getUser(), true);
        } else {
            return new OrderDto(orderRequest.getOrder().getUser(), false);
        }
    }
}
