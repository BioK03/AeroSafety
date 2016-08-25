-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 25 Août 2016 à 14:57
-- Version du serveur :  5.6.24
-- Version de PHP :  5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projetpermis`
--

-- --------------------------------------------------------

--
-- Structure de la table `action`
--

CREATE TABLE IF NOT EXISTS `action` (
  `id` int(11) NOT NULL,
  `fk_action` int(11) DEFAULT NULL,
  `wording` char(25) DEFAULT NULL,
  `scoreMinimum` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `action`
--

INSERT INTO `action` (`id`, `fk_action`, `wording`, `scoreMinimum`) VALUES
(1, NULL, 'Se mettre en tenue', 1),
(2, 1, 'Pr?paration v?hicule', 5),
(3, 2, 'Effectuer manoeuvre', 8),
(4, NULL, 'Analyser panne(s)', 2),
(5, 4, 'Resoudre panne(s)', 5);

-- --------------------------------------------------------

--
-- Structure de la table `action__mission`
--

CREATE TABLE IF NOT EXISTS `action__mission` (
  `fk_action` int(11) NOT NULL,
  `fk_mission` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `action__mission`
--

INSERT INTO `action__mission` (`fk_action`, `fk_mission`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(4, 2),
(5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `indicator`
--

CREATE TABLE IF NOT EXISTS `indicator` (
  `id` int(11) NOT NULL,
  `fk_action` int(11) NOT NULL,
  `wording` char(50) DEFAULT NULL,
  `valueIfCheck` int(11) DEFAULT NULL,
  `valueIfUnCheck` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `indicator`
--

INSERT INTO `indicator` (`id`, `fk_action`, `wording`, `valueIfCheck`, `valueIfUnCheck`) VALUES
(1, 1, 'Prendre ses outils', 1, -1),
(2, 1, 'Prendre des explosifs', -1, 1),
(3, 3, 'Conduire ? 110 km/h', -2, 2),
(4, 3, 'Conduire les yeux ouverts', 3, -6),
(5, 3, 'Avoir les deux mains sur le volant', 1, 0),
(6, 4, 'S informer aupr?s des techniciens', 1, 0),
(7, 4, 'Consulter le manuel', 0, 0),
(8, 4, 'Respecter la proc?dure', 2, -2),
(9, 4, 'Demander de l aide ? la tour de contr', -1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE IF NOT EXISTS `inscription` (
  `id` int(11) NOT NULL,
  `fk_learner` int(11) NOT NULL,
  `fk_mission` int(11) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `inscription`
--

INSERT INTO `inscription` (`id`, `fk_learner`, `fk_mission`, `date`) VALUES
(1, 1, 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `inscription__action`
--

CREATE TABLE IF NOT EXISTS `inscription__action` (
  `id` int(11) NOT NULL,
  `fk_inscription` int(11) NOT NULL,
  `fk_action` int(11) NOT NULL,
  `sort` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `learner`
--

CREATE TABLE IF NOT EXISTS `learner` (
  `id` int(11) NOT NULL,
  `surname` char(25) DEFAULT NULL,
  `forname` char(25) DEFAULT NULL,
  `salt` char(25) DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  `mdp` char(80) DEFAULT NULL,
  `role` char(25) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `learner`
--

INSERT INTO `learner` (`id`, `surname`, `forname`, `salt`, `email`, `mdp`, `role`) VALUES
(1, 'Doe', 'John', '144be33f', 'john.doe@email.com', '954A7E69F5FE03835BBCB1596FBF3EB386747F4EBF8E218DB3D1DE4DD0466B30', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE IF NOT EXISTS `mission` (
  `id` int(11) NOT NULL,
  `wording` char(25) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `mission`
--

INSERT INTO `mission` (`id`, `wording`) VALUES
(1, 'Mission A'),
(2, 'Mission B');

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '0');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `action`
--
ALTER TABLE `action`
  ADD PRIMARY KEY (`id`), ADD KEY `Act_KEY_FK_ACTION_PREDECESSOR` (`fk_action`);

--
-- Index pour la table `action__mission`
--
ALTER TABLE `action__mission`
  ADD PRIMARY KEY (`fk_action`,`fk_mission`), ADD KEY `MisGoa_KEY_FK_MISSION` (`fk_mission`), ADD KEY `ActGoa_KEY_FK_ACTION` (`fk_action`);

--
-- Index pour la table `indicator`
--
ALTER TABLE `indicator`
  ADD PRIMARY KEY (`id`), ADD KEY `Ind_KEY_FK_ACTION` (`fk_action`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`), ADD KEY `Ins_KEY_FK_LEARNER` (`fk_learner`), ADD KEY `Ins_KEY_FK_GAME` (`fk_mission`);

--
-- Index pour la table `inscription__action`
--
ALTER TABLE `inscription__action`
  ADD PRIMARY KEY (`id`), ADD KEY `LeaAct_KEY_FK_INSCRIPTION` (`fk_inscription`), ADD KEY `LeaAct_KEY_FK_ACTION` (`fk_action`);

--
-- Index pour la table `learner`
--
ALTER TABLE `learner`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `action`
--
ALTER TABLE `action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `indicator`
--
ALTER TABLE `indicator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `inscription__action`
--
ALTER TABLE `inscription__action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `learner`
--
ALTER TABLE `learner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `mission`
--
ALTER TABLE `mission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `action`
--
ALTER TABLE `action`
ADD CONSTRAINT `Act_FK_ACTION` FOREIGN KEY (`fk_action`) REFERENCES `action` (`id`);

--
-- Contraintes pour la table `action__mission`
--
ALTER TABLE `action__mission`
ADD CONSTRAINT `ActGoa_FK_ACTION` FOREIGN KEY (`fk_action`) REFERENCES `action` (`id`),
ADD CONSTRAINT `ActGoa_FK_MISSION` FOREIGN KEY (`fk_mission`) REFERENCES `mission` (`id`);

--
-- Contraintes pour la table `indicator`
--
ALTER TABLE `indicator`
ADD CONSTRAINT `Ind_FK_ACTION` FOREIGN KEY (`fk_action`) REFERENCES `action` (`id`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
ADD CONSTRAINT `Ins_FK_LEARNER` FOREIGN KEY (`fk_learner`) REFERENCES `learner` (`id`),
ADD CONSTRAINT `Ins_FK_MISSION` FOREIGN KEY (`fk_mission`) REFERENCES `mission` (`id`);

--
-- Contraintes pour la table `inscription__action`
--
ALTER TABLE `inscription__action`
ADD CONSTRAINT `LeaAct_FK_ACTION` FOREIGN KEY (`fk_action`) REFERENCES `action` (`id`),
ADD CONSTRAINT `LeaAct_FK_INSCRIPTION` FOREIGN KEY (`fk_inscription`) REFERENCES `inscription` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
