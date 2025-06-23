-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Jun 23, 2025 at 10:16 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `complain`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_complain`
--

CREATE TABLE `customer_complain` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `date` date NOT NULL,
  `cust_contract_id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'In Progress'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_complain`
--

INSERT INTO `customer_complain` (`id`, `title`, `description`, `date`, `cust_contract_id`, `status`) VALUES
(1, 'test title1 updated', 'test description 1', '2025-06-21', 1, 'In Progress'),
(2, 'test tile 2', 'test title 2', '2025-06-20', 2, 'In Progress'),
(3, 'test title 3 updated', 'test description 3 updated', '2025-06-21', 1, 'In Progress'),
(5, 'test title 5', 'test title 5', '2025-06-20', 3, 'In Progress'),
(7, 'test title 7', 'test title 7', '2025-06-20', 3, 'Resolved');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_complain`
--
ALTER TABLE `customer_complain`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_complain`
--
ALTER TABLE `customer_complain`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
