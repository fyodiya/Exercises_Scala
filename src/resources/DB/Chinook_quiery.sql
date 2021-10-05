--1. Provide a query showing Customers
--(just their full names, customer ID and country) who are not in the US.
--SELECT c.FirstName , c.LastName , c.CustomerId , c.Country FROM customers c
--WHERE c.Country != 'USA'
--ORDER BY c.Country ASC;

--2. brazil_customers.sql: Provide a query only showing the Customers from Brazil.
--SELECT * FROM customers c
--WHERE c.Country = "Brazil";

--3. brazil_customers_invoices.sql:
--Provide a query showing the Invoices of customers who are from Brazil.
--The resultant table should show the customer's full name,
--Invoice ID, Date of the invoice and billing country.
--HINT we need to join 2 tables together for this to work
--SELECT c.FirstName , c.LastName , i.InvoiceId , i.InvoiceDate , i.BillingCountry , c.Country
--FROM customers c
--INNER JOIN invoices i
--ON c.CustomerId = i.CustomerId
--WHERE c.Country = "Brazil"
--ORDER BY c.LastName ;
--JUST ADD WHERE :)

--4 sales_agents.sql: Provide a query showing only the Employees who are Sales Agents.
--SELECT * FROM employees e
--WHERE e.Title LIKE "%agent%";

--5 unique_invoice_countries.sql:
-- Provide a query showing a unique/distinct list of billing countries from the Invoices table.
-- ORDER BY ALPHABET
--SELECT DISTINCT i.BillingCountry
--FROM invoices i
--ORDER BY i.BillingCountry ;

--6. sales_agent_invoices.sql:
--Provide a query that shows the invoices associated with each sales agent.
--The resultant table should include the Sales Agent's full name.
-- SO we need TWO JOINS across 3 tables
--SELECT i.InvoiceId , i.InvoiceDate , e.FirstName , e.LastName FROM invoices i
--JOIN customers c
--ON c.CustomerId = i.CustomerId  -- careful with joins
--JOIN employees e
--ON c.SupportRepId = e.EmployeeId ;

--7. invoice_totals.sql:
--Provide a query that shows the
--Invoice Total, Customer name, Country and Sale Agent name for all invoices and customers.
--SELECT i.Total, c.FirstName , c.LastName , e.FirstName , e.LastName FROM invoices i
--JOIN customers c
--ON c.CustomerId = i.CustomerId  -- careful with joins
--JOIN employees e
--ON c.SupportRepId = e.EmployeeId ;

--8 total_invoices_{year}.sql: How many Invoices were there in 2009 and 2011?
--
--Answer: "83" "83"

--9. total_sales_{year}.sql: What are the respective total sales for each of those years?

--Answer: "449.46" "469.58"
--SELECT * FROM invoices i ;
--SELECT date('now'), time('now'); --3 hours back so Greenwitch(sic?) time
--https://stackoverflow.com/questions/13020611/how-to-select-rows-by-date-in-sqlite
--SELECT COUNT(*), SUM(i2.Total) FROM invoices i2
--where i2.InvoiceDate >= datetime('2009-01-01 00:00:00')
--  AND i2.InvoiceDate <  datetime('2010-01-01 00:00:00'); -- in a typed database
----WHERE i2.InvoiceDate LIKE "2009%";

--  SELECT COUNT(*), SUM(i2.Total) FROM invoices i2
--where i2.InvoiceDate >= datetime('2011-01-01 00:00:00')
--  AND i2.InvoiceDate <  datetime('2012-01-01 00:00:00'); -- in a typed database

--total_sales_{year}.sql: What are the respective total sales for each of those years?
--
--Answer: "449.46" "469.58"

--10 invoice_37_line_item_count.sql: Looking at the InvoiceLine table,
-- provide a query that COUNTs the number of line items for Invoice ID 37.
--SELECT COUNT(*) FROM invoice_items ii
--WHERE InvoiceId = 37;

--11 This involves GROUP BY which we are going to cover after the break
--line_items_per_invoice.sql: Looking at the InvoiceLine table, provide a query
--that COUNTs the number of line items for each Invoice.
--HINT: GROUP BY

--12 - line_item_track.sql: Provide a query that includes the purchased track name with each invoice line item

--13 line_item_track_artist.sql:
-- Provide a query that includes the purchased track name AND artist name with each invoice line item.

--l: Provide a query that includes the purchased track name with each invoice line item.

--SELECT
--    Name,
--    Title
--FROM
--    artists
--    -- so we get all left rows but right row might not have a match
--JOIN albums ON
--    artists.ArtistId = albums.ArtistId
--ORDER BY Name DESC;

--SELECT a3.AlbumId , a3.Title , a4.Name FROM albums a3
----INNER JOIN artists a4
--JOIN artists a4 -- here the same
--ON a3.ArtistId = a4.ArtistId
--WHERE a4.Name LIKE "B%"
--ORDER BY a4.Name ASC
--;
--get ll all albums by artists whose name starts with B
--ORDER THEM by artist name

--SELECT a3.AlbumId , a3.Title , a4.Name FROM albums a3
----INNER JOIN artists a4
--JOIN artists a4 -- here the same
--ON a3.ArtistId = a4.ArtistId -- without this it would join every row agains every row in these tables
--LIMIT 30;
--SELECT * FROM tracks t2
--LIMIT 30;
--SELECT * FROM albums a2
--LIMIT 20;
--SELECT * FROM artists a;