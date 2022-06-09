-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 08 juin 2022 à 17:56
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `infomatos`
--

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `Code_Materiel` varchar(50) COLLATE utf8_bin NOT NULL,
  `Nom_Materiel` varchar(50) COLLATE utf8_bin NOT NULL,
  `Etat_Materiel` int(1) NOT NULL,
  `Id_Type` varchar(50) COLLATE utf8_bin NOT NULL,
  `Id_Salle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`Code_Materiel`, `Nom_Materiel`, `Etat_Materiel`, `Id_Type`, `Id_Salle`) VALUES
('1', 'pc001', 1, '1', 1),
('101', 'pc002', 0, '1', 1),
('2', 'pc004', 2, '1', 3),
('e100', 'ecran001', 0, '2', 3),
('p100', 'pc006', 2, '1', 1);

-- --------------------------------------------------------

--
-- Structure de la table `probleme`
--

CREATE TABLE `probleme` (
  `Id_Probleme` int(11) NOT NULL,
  `Date_Probleme` date NOT NULL,
  `Etat_Probleme` tinyint(1) NOT NULL,
  `Note_Problem` varchar(50) COLLATE utf8_bin NOT NULL,
  `Id_Utilisateur` int(11) NOT NULL,
  `Id_Utilisateur_Admin` int(11) NOT NULL,
  `Code_Materiel` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `Id_Salle` int(11) NOT NULL,
  `Nom_Salle` varchar(50) COLLATE utf8_bin NOT NULL,
  `Longueur_Salle` float NOT NULL,
  `Largeur_Salle` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`Id_Salle`, `Nom_Salle`, `Longueur_Salle`, `Largeur_Salle`) VALUES
(1, '001', 9, 9),
(3, '003', 9, 9),
(4, '004', 9, 9),
(5, '201', 6, 6);

--
-- Déclencheurs `salle`
--
DELIMITER $$
CREATE TRIGGER `updateSalle` BEFORE DELETE ON `salle` FOR EACH ROW BEGIN
    UPDATE materiel SET `Id_Salle`= null WHERE materiel.Id_Salle = old.Id_Salle;
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `type_materiel`
--

CREATE TABLE `type_materiel` (
  `Id_Type` varchar(50) COLLATE utf8_bin NOT NULL,
  `Nom_Type` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `type_materiel`
--

INSERT INTO `type_materiel` (`Id_Type`, `Nom_Type`) VALUES
('1', 'pc'),
('2', 'écran');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `Id_Utilisateur` int(11) NOT NULL,
  `Nom_Utilisateur` varchar(50) COLLATE utf8_bin NOT NULL,
  `Prenom_Utilisateur` varchar(50) COLLATE utf8_bin NOT NULL,
  `Mail_Utilisateur` varchar(50) COLLATE utf8_bin NOT NULL,
  `IsAdmin` tinyint(1) NOT NULL,
  `mdp_utilisateur` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`Id_Utilisateur`, `Nom_Utilisateur`, `Prenom_Utilisateur`, `Mail_Utilisateur`, `IsAdmin`, `mdp_utilisateur`) VALUES
(1, 'Di MArtino', 'Fabio', 'xxx', 0, '40bd001563085fc35165329ea1ff5c5ecbdbbeef'),
(2, 'Frosini', 'Adrien', 'adrien.frosini@gmail.com', 1, '8cb2237d0679ca88db6464eac60da96345513964'),
(4, 'Cost', 'Gabriel', 'gabriel.cost@gmail.com', 0, '7c4a8d09ca3762af61e59520943dc26494f8941b'),
(5, 'Sangiardi', 'Sophia', 'xxxx', 0, '40bd001563085fc35165329ea1ff5c5ecbdbbeef');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`Code_Materiel`),
  ADD KEY `Materiel_Type_Materiel_FK` (`Id_Type`),
  ADD KEY `Materiel_Salle0_FK` (`Id_Salle`);

--
-- Index pour la table `probleme`
--
ALTER TABLE `probleme`
  ADD PRIMARY KEY (`Id_Probleme`),
  ADD KEY `Probleme_Utilisateur_FK` (`Id_Utilisateur`),
  ADD KEY `Probleme_Admin0_FK` (`Id_Utilisateur_Admin`),
  ADD KEY `Probleme_Materiel1_FK` (`Code_Materiel`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`Id_Salle`);

--
-- Index pour la table `type_materiel`
--
ALTER TABLE `type_materiel`
  ADD PRIMARY KEY (`Id_Type`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`Id_Utilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `probleme`
--
ALTER TABLE `probleme`
  MODIFY `Id_Probleme` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `Id_Salle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `Id_Utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD CONSTRAINT `Materiel_Salle0_FK` FOREIGN KEY (`Id_Salle`) REFERENCES `salle` (`Id_Salle`),
  ADD CONSTRAINT `Materiel_Type_Materiel_FK` FOREIGN KEY (`Id_Type`) REFERENCES `type_materiel` (`Id_Type`);

--
-- Contraintes pour la table `probleme`
--
ALTER TABLE `probleme`
  ADD CONSTRAINT `Probleme_Admin0_FK` FOREIGN KEY (`Id_Utilisateur_Admin`) REFERENCES `utilisateur` (`Id_Utilisateur`),
  ADD CONSTRAINT `Probleme_Materiel1_FK` FOREIGN KEY (`Code_Materiel`) REFERENCES `materiel` (`Code_Materiel`),
  ADD CONSTRAINT `Probleme_Utilisateur_FK` FOREIGN KEY (`Id_Utilisateur`) REFERENCES `utilisateur` (`Id_Utilisateur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
