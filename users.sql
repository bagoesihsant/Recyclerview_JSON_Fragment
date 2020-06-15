-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2020 at 05:58 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users`
--

-- --------------------------------------------------------

--
-- Table structure for table `users_schedule`
--

CREATE TABLE `users_schedule` (
  `id_schedule` int(11) NOT NULL,
  `schedule` varchar(50) NOT NULL,
  `schedule_teacher` varchar(50) NOT NULL,
  `schedule_status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_schedule`
--

INSERT INTO `users_schedule` (`id_schedule`, `schedule`, `schedule_teacher`, `schedule_status`) VALUES
(1, 'Mathematics', 'Ganjar Pranowo', 1),
(2, 'Applied English', 'Barack Obama', 1),
(3, 'Basic Programming', 'Isa Hamdan', 1),
(4, 'Java Programming', 'Isa Hamdan', 1),
(5, 'Basic Algorithm', 'Munih Dian', 1),
(6, 'Database Management', 'Bety Etikasari', 0),
(7, 'Basic PHP', 'Isa Hamdan', 1),
(8, 'Business Management', 'Elly Antikasari', 0),
(9, 'Software Maintenance', 'Nugroho Setyo', 1),
(10, 'REST API', 'Angga Gumilang', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users_table`
--

CREATE TABLE `users_table` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_table`
--

INSERT INTO `users_table` (`id`, `name`, `email`, `password`) VALUES
(1, 'Bagoes', 'bagoes@gmail.com', '$2y$10$e7DFprhGTe4a5wVz6i5KxuOHk3GDGEOOeW/D4hh/rw4f4YZSxF5iu'),
(2, 'Bagoes Ihsan Taufiqurrahman', 'bagoesihsant@gmail.com', '$2y$10$3eC1QPmWRlYiRBa1.Cx/I.fpAXKbDgkjjtOmVR0UZzh.cQQSS.rzm');

-- --------------------------------------------------------

--
-- Table structure for table `users_task`
--

CREATE TABLE `users_task` (
  `id_task` int(11) NOT NULL,
  `task` varchar(100) NOT NULL,
  `status` int(1) NOT NULL,
  `giver` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_task`
--

INSERT INTO `users_task` (`id_task`, `task`, `status`, `giver`) VALUES
(1, 'Creating a basic CRUD System on PHP', 0, 'Isa Hamdan'),
(2, 'Creating Basic CRUD System in Java', 0, 'Isa Hamdan'),
(3, 'Creating Flowchart about Making Noodles', 1, 'Munih Dian'),
(4, 'Creating Entity Relationship Diagram from scratch', 0, 'Bety Etikasari'),
(5, 'Creating Website Prototype for Client', 1, 'Angga Gumilang'),
(6, 'Creating Business Model for Startup', 1, 'Elly Antikasari'),
(7, 'Practice Forward Engineering on Software', 0, 'Nugroho Setyo'),
(8, 'Complete Algorithms for Integrated System', 1, 'Angga Gumilang'),
(9, 'Create Algorithms for Making a cup of coffee', 1, 'Munih Dian'),
(10, 'Create database', 0, 'Bety Etikasari');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users_schedule`
--
ALTER TABLE `users_schedule`
  ADD PRIMARY KEY (`id_schedule`);

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_task`
--
ALTER TABLE `users_task`
  ADD PRIMARY KEY (`id_task`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users_schedule`
--
ALTER TABLE `users_schedule`
  MODIFY `id_schedule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users_task`
--
ALTER TABLE `users_task`
  MODIFY `id_task` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
