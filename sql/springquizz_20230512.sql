-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 12 mai 2023 à 01:44
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `springquizz`
--

-- --------------------------------------------------------

--
-- Structure de la table `quizz_answer`
--

CREATE TABLE `quizz_answer` (
  `id` int(11) NOT NULL,
  `id_question` int(11) NOT NULL DEFAULT 0,
  `rank` smallint(6) NOT NULL DEFAULT 0,
  `title` varchar(500) NOT NULL,
  `is_correct` tinyint(4) NOT NULL DEFAULT 0,
  `date_created` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `quizz_answer`
--

INSERT INTO `quizz_answer` (`id`, `id_question`, `rank`, `title`, `is_correct`, `date_created`) VALUES
(1, 2, 0, 'aaaa', 1, '2023-05-12 01:34:34'),
(2, 2, 1, 'bbbb', 1, '2023-05-12 01:34:34'),
(3, 3, 0, 'aaaa', 0, '2023-05-12 01:34:48'),
(4, 3, 1, 'bbbb', 1, '2023-05-12 01:34:48'),
(5, 4, 0, 'aaaa', 0, '2023-05-12 01:35:01'),
(6, 4, 1, 'bbbb', 1, '2023-05-12 01:35:01'),
(7, 5, 0, 'aaaa', 0, '2023-05-12 01:35:01'),
(8, 5, 1, 'bbbb', 1, '2023-05-12 01:35:01'),
(9, 6, 0, 'qqqq', 0, '2023-05-12 01:36:34'),
(10, 7, 0, 'fdsfsdfsdfsdf', 0, '2023-05-12 01:36:51'),
(11, 7, 1, 'fsdfsdfsdfsdfsdfsdfsdfdsfdsf', 0, '2023-05-12 01:36:51'),
(12, 7, 2, 'fsdfsdfsdf', 0, '2023-05-12 01:36:51'),
(13, 8, 0, 'fsdfsdfsdf', 0, '2023-05-12 01:37:08'),
(14, 8, 1, 'fsdfsdfsdsdfsdf', 1, '2023-05-12 01:37:08');

-- --------------------------------------------------------

--
-- Structure de la table `quizz_question`
--

CREATE TABLE `quizz_question` (
  `id` int(11) NOT NULL,
  `type_choice` tinyint(4) NOT NULL DEFAULT 0,
  `id_user` int(11) NOT NULL DEFAULT 0,
  `title` text NOT NULL,
  `date_created` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `quizz_question`
--

INSERT INTO `quizz_question` (`id`, `type_choice`, `id_user`, `title`, `date_created`) VALUES
(1, 1, 0, '', '2023-05-12 01:31:10'),
(2, 1, 0, '', '2023-05-12 01:34:34'),
(3, 1, 0, '', '2023-05-12 01:34:48'),
(4, 1, 0, '', '2023-05-12 01:35:01'),
(5, 1, 0, '', '2023-05-12 01:35:01'),
(6, 2, 0, 'aaaaa', '2023-05-12 01:36:34'),
(7, 1, 0, 'qqqqqqqqq', '2023-05-12 01:36:51'),
(8, 2, 0, 'fsdfsdfsdfdsfds', '2023-05-12 01:37:08');

-- --------------------------------------------------------

--
-- Structure de la table `quizz_questions`
--

CREATE TABLE `quizz_questions` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `quizz_answer`
--
ALTER TABLE `quizz_answer`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `quizz_question`
--
ALTER TABLE `quizz_question`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `quizz_questions`
--
ALTER TABLE `quizz_questions`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `quizz_answer`
--
ALTER TABLE `quizz_answer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `quizz_question`
--
ALTER TABLE `quizz_question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `quizz_questions`
--
ALTER TABLE `quizz_questions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
