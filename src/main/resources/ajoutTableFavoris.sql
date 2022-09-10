CREATE TABLE `netflix`.`favoris` (
  `id_favoris` INT NOT NULL AUTO_INCREMENT,
  `id_abonnement` VARCHAR(45) NULL,
  `id_user` BIGINT NULL,
  `id_netflix` INT NULL,
  `quantite` INT NULL,
  PRIMARY KEY (`id_favoris`),
  INDEX `IdAbonnement_pour_idFavoris_idx` (`id_abonnement` ASC) VISIBLE,
  INDEX `idUser_pour_idFavoris_fk_idx` (`id_user` ASC) VISIBLE,
  INDEX `idNetflix_pour_IdFavoris_fk_idx` (`id_netflix` ASC) VISIBLE,
  CONSTRAINT `IdAbonnement_pour_idFavoris_fk`
    FOREIGN KEY (`id_abonnement`)
    REFERENCES `netflix`.`abonnement` (`id_abonnement`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idUser_pour_idFavoris_fk`
    FOREIGN KEY (`id_user`)
    REFERENCES `netflix`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idNetflix_pour_IdFavoris_fk`
    FOREIGN KEY (`id_netflix`)
    REFERENCES `netflix`.`netflix` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
