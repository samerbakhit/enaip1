package com.samer.Enaip.Servizi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.samer.Enaip.modelli.GoldPrice;



@Service
public class GoldPriceService {

    private final RestTemplate restTemplate;

    // Iniezione di RestTemplate tramite costruttore
    public GoldPriceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Metodo per ottenere il prezzo dell'oro
    public GoldPrice getGoldPrice() {
        // Sostituisci "YOUR_API_KEY" con la tua vera chiave API
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=TT4PE4UIE52HASLV";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("API Response: " + response);
        // RestTemplate restituirà un oggetto JSON che possiamo mappare direttamente su un oggetto GoldPrice
        return restTemplate.getForObject(url, GoldPrice.class);
    }
}