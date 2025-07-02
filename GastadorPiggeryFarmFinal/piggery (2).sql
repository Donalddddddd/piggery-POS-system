-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2023 at 04:41 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `piggery`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `secretQuestion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `secretQuestion`) VALUES
(1, 'admin', 'admin', '052423');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `phone` int(255) NOT NULL,
  `address` varchar(300) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `pig_id` int(100) NOT NULL,
  `ageOfPig` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `gender`, `age`, `phone`, `address`, `customer_id`, `pig_id`, `ageOfPig`, `quantity`, `price`, `date`) VALUES
(10, 'donald', 'male', 21, 1234, 'caloocan city', 1, 1, 'Available', 1, 21212, '2023-07-16'),
(11, 'jam', 'female', 20, 12345, 'manila city', 2, 2, 'Available', 1, 21212, '2023-07-16'),
(12, 'don', 'asda', 23, 123, 'asdad', 3, 1, 'Available', 1, 21212, '2023-07-16'),
(13, 'adsas', 'asda', 12, 12312, 'adasdas', 4, 2, 'Available', 1, 21212, '2023-07-16'),
(14, 'jecjec', 'male', 23, 123456, 'valenzuela ', 5, 4, 'Available', 1, 200, '2023-07-16'),
(15, 'sadad', 'male', 23, 2131, 'wqadsad', 6, 1, 'Available', 1, 21212, '2023-07-16'),
(16, 'Denzel', 'male', 20, 1231412, 'pasig', 7, 2, 'Available', 1, 3000, '2023-07-17');

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `id` int(11) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `total` double NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`id`, `customer_id`, `total`, `date`) VALUES
(8, 1, 21212, '2023-07-16'),
(9, 2, 21212, '2023-07-16'),
(10, 3, 21212, '2023-07-16'),
(11, 4, 21212, '2023-07-16'),
(12, 5, 200, '2023-07-16'),
(13, 6, 21212, '2023-07-16'),
(14, 7, 3000, '2023-07-17');

-- --------------------------------------------------------

--
-- Table structure for table `piginfo`
--

CREATE TABLE `piginfo` (
  `pig` int(11) NOT NULL,
  `pig_id` int(100) NOT NULL,
  `ageOfPig` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `piginfo`
--

INSERT INTO `piginfo` (`pig`, `pig_id`, `ageOfPig`, `status`, `price`, `date`) VALUES
(1, 1, '1', 'Available', 21212, '2023-05-21'),
(2, 2, '2', 'Available', 3000, '2023-05-21'),
(4, 3, '3', 'Available', 50000, '2023-07-12'),
(5, 4, '3', 'Available', 200, '2023-07-13');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `piginfo`
--
ALTER TABLE `piginfo`
  ADD PRIMARY KEY (`pig`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `customer_info`
--
ALTER TABLE `customer_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `piginfo`
--
ALTER TABLE `piginfo`
  MODIFY `pig` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
