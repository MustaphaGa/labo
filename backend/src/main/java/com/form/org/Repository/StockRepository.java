package com.form.org.Repository;

import com.form.org.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    //Optional<Stock> findByIdStock(Integer idStock);
    Optional<Stock> findBydateStock(Date dateStock);

  //@Query(value = "SELECT SUM(bc.QuantiteCommande)  AS difference" +
          //" FROM BonCommande bc JOIN Article a ON bc.idArticle = a.idArticle JOIN Stock s ON s.idArticle = a.idArticle" +
           //" WHERE( a.idArticle = s.idArticle) and (a.idArticle = bc.idArticle)")
    @Query(value = "SELECT ((SELECT QuatiteStock FROM Stock  WHERE idArticle=:idArticle) - SUM(QuantiteCommande)) AS difference FROM BonCommande bc WHERE idArticle=:idArticle ")
    BigDecimal calculateStock(@Param("idArticle") Integer idArticle);
}
