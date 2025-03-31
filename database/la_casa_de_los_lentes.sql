-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-02-2025 a las 02:40:21
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `la_casa_de_los_lentes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `montura`
--

CREATE TABLE `montura` (
  `codigoMontura` int(11) NOT NULL,
  `tipoMontura` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `longitudMontura` double DEFAULT NULL,
  `anchoPuente` double DEFAULT NULL,
  `longitudVarilla` double DEFAULT NULL,
  `longitudLente` double DEFAULT NULL,
  `linkFoto` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `montura`
--

INSERT INTO `montura` (`codigoMontura`, `tipoMontura`, `precio`, `longitudMontura`, `anchoPuente`, `longitudVarilla`, `longitudLente`, `linkFoto`) VALUES
(1, 'Acetato', 70.5, 54, 20, 140, 140, 'https://www.visioncenter.com.pe/cdn/shop/files/8053672357936_1_1000x1000.png?v=1720009609'),
(2, 'Titanio', 50, 50, 30, 120, 120, 'https://www.valkur.com.pe/cdn/shop/files/LUNA_a22aa55e-2634-4503-afdd-19f50db3c7b6_2.png?v=1686537445&width=1000'),
(3, 'Aleaciones Titanio', 80, 25, 23, 120, 123, 'https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaPE/18299814_1/w=1500,h=1500,fit=pad'),
(4, 'Plastico', 65, 20, 15, 100, 110, 'https://tonybernard.store/wp-content/uploads/2023/11/Diseno-sin-titulo-2023-11-28T122127.046.png'),
(5, 'Metal', 120, 62, 24, 120, 120, 'https://oechsle.vteximg.com.br/arquivos/ids/17414748-1000-1000/imageUrl_1.jpg?v=638505707534230000'),
(6, 'Berilio', 100, 12, 12, 12, 12, 'https://www.lentesplus.com/media/catalog/product/V/N/VNM.A6047.0GRY.54_image_2.png?auto=webp&format=png&width=960&height=1200&fit=cover');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `dniPaciente` int(11) NOT NULL,
  `nombrePaciente` varchar(100) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `fechaVisita` date DEFAULT NULL,
  `razonVisita` varchar(100) DEFAULT NULL,
  `enfermedades` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`dniPaciente`, `nombrePaciente`, `direccion`, `telefono`, `fechaVisita`, `razonVisita`, `enfermedades`) VALUES
(10241558, 'Mirella Castro', 'Santa Anita - Agustino', 920149522, '2025-02-06', 'Compra', 'Catarata'),
(10241559, 'Mirella Castro', 'Santa Anita - Agustino', 920149522, '2025-02-06', 'Compra', 'Astigmatismo'),
(41255558, 'Alessandro Chavez', 'Ate - Constructores', 952149355, '2025-01-25', 'RevisiÃ³n', 'Ninguno'),
(45218776, 'Monica Huaman', 'Miraflores 1046', 942158377, '2025-01-10', 'RevisiÃ³n', 'Miopia'),
(52419886, 'Juan Perez', 'La Molina 406', 945189355, '2025-02-01', 'Consulta', 'Daltonismo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registroventa`
--

CREATE TABLE `registroventa` (
  `codigoBoleta` int(11) NOT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `dniPaciente` int(11) NOT NULL,
  `esferaIzq` double DEFAULT NULL,
  `cilindroIzq` double DEFAULT NULL,
  `gradoIzq` double DEFAULT NULL,
  `distanciaIzq` double DEFAULT NULL,
  `esferaDer` double DEFAULT NULL,
  `cilindroDer` double DEFAULT NULL,
  `gradoDer` double DEFAULT NULL,
  `distanciaDer` double DEFAULT NULL,
  `codigoMontura` int(11) DEFAULT NULL,
  `tipoLuna` varchar(100) DEFAULT NULL,
  `costoTotal` int(11) DEFAULT NULL,
  `fechaEntrega` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `registroventa`
--

INSERT INTO `registroventa` (`codigoBoleta`, `fechaCreacion`, `dniPaciente`, `esferaIzq`, `cilindroIzq`, `gradoIzq`, `distanciaIzq`, `esferaDer`, `cilindroDer`, `gradoDer`, `distanciaDer`, `codigoMontura`, `tipoLuna`, `costoTotal`, `fechaEntrega`) VALUES
(1000000, '2025-02-02', 10241558, 1.7, 1.5, 1.5, 1.5, 2.5, 4.1, 5, 2.4, 1, 'cr_39', 250, '2025-02-10'),
(1000001, '2025-01-15', 45218776, 3.2, 2.3, 4.5, 1.2, 2.41, 2.45, 1.2, 3.4, 3, 'cristal', 140, '2025-02-14'),
(1000002, '2025-01-25', 41255558, 1.2, 4, 3, 2, 1.5, 2.3, 4.5, 1.2, 5, 'futurex', 150, '2025-02-08'),
(1000003, '2025-02-01', 52419886, 1.2, 4.5, 5, 4.2, 1.2, 4.5, 6, 3.1, 1, 'trivex', 150, '2025-02-07'),
(1000004, '2025-01-25', 41255558, 1.2, 4, 3, 2, 1.5, 2.3, 4.5, 1.2, 5, 'trivex', 150, '2025-02-08'),
(1000005, '2025-01-25', 41255558, 1.2, 4, 3, 2, 1.5, 2.3, 4.5, 1.2, 5, 'cr_39', 200, '2025-02-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombreUsuario` varchar(100) NOT NULL,
  `apellidoUsuario` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombreUsuario`, `apellidoUsuario`, `correo`, `contraseña`) VALUES
('Eduardo', 'Leon', 'eduardo.leon.b3@gmail.com', '123'),
('Julia', 'Guevara', 'julia@gmail.com', '1234'),
('Raul', 'Mendez', 'mendez@gmail.com', '12345');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `montura`
--
ALTER TABLE `montura`
  ADD PRIMARY KEY (`codigoMontura`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`dniPaciente`);

--
-- Indices de la tabla `registroventa`
--
ALTER TABLE `registroventa`
  ADD PRIMARY KEY (`codigoBoleta`),
  ADD KEY `codigoMontura` (`codigoMontura`),
  ADD KEY `dniPaciente` (`dniPaciente`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `registroventa`
--
ALTER TABLE `registroventa`
  ADD CONSTRAINT `registroventa_ibfk_1` FOREIGN KEY (`codigoMontura`) REFERENCES `montura` (`codigoMontura`),
  ADD CONSTRAINT `registroventa_ibfk_2` FOREIGN KEY (`dniPaciente`) REFERENCES `paciente` (`dniPaciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
