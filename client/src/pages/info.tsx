import "../index.css"
import { twMerge } from "tailwind-merge"
import type {  ReactNode } from "react"
import React, { useState, useEffect } from 'react';


import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableFooter,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table"

function Info() {
    return (
        <>
        

        <div className='min-h-screen bg-white px-4 py-12 text-zinc-900'>
            <div className=" mx-auto max-w-16xl grid grid-cols-12 gap-4">
                <Block className=""></Block>
                <TableBlock></TableBlock>
                <Block><EquipmentList></EquipmentList></Block>
                <Block></Block>
                <Block></Block>
                <Block></Block>
            </div>
        </div>


            
        </>
    )
}

export default Info

// UNDERSTAND WHAT IS GOING ON BELOW

type Props = { // what is type? what is a prop?
    className?: string;   // why do i need this line?
    children?: ReactNode;  // is ? for optional? what is a react node? 
};

const Block = ({ children, className, ...rest } : Props)  => { // what is this doing? is it a for each? is it defining each as a prop?
    return (
        <div className={twMerge("h-30 col-span-4 rounded-lg border border-zinc-200 bg-zinc-100 p-6", className )} {...rest}>{children}
</div>
    );
};



const invoices = [
  {
    invoice: "INV001",
    paymentStatus: "Paid",
    totalAmount: "$250.00",
    paymentMethod: "Credit Card",
  },
  {
    invoice: "INV002",
    paymentStatus: "Pending",
    totalAmount: "$150.00",
    paymentMethod: "PayPal",
  },
  {
    invoice: "INV003",
    paymentStatus: "Unpaid",
    totalAmount: "$350.00",
    paymentMethod: "Bank Transfer",
  },
  {
    invoice: "INV004",
    paymentStatus: "Paid",
    totalAmount: "$450.00",
    paymentMethod: "Credit Card",
  },
  {
    invoice: "INV005",
    paymentStatus: "Paid",
    totalAmount: "$550.00",
    paymentMethod: "PayPal",
  },
  {
    invoice: "INV006",
    paymentStatus: "Pending",
    totalAmount: "$200.00",
    paymentMethod: "Bank Transfer",
  },
  {
    invoice: "INV007",
    paymentStatus: "Unpaid",
    totalAmount: "$300.00",
    paymentMethod: "Credit Card",
  },
]


function TableBlock() {

    return (
    <Block className="h-max">
        <Table>
      <TableCaption>A list of your recent invoices.</TableCaption>
      <TableHeader>
        <TableRow>
          <TableHead className="w-[100px]">Invoice</TableHead>
          <TableHead>Status</TableHead>
          <TableHead>Method</TableHead>
          <TableHead className="text-right">Amount</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>
        {invoices.map((invoice) => (
          <TableRow key={invoice.invoice}>
            <TableCell className="font-medium">{invoice.invoice}</TableCell>
            <TableCell>{invoice.paymentStatus}</TableCell>
            <TableCell>{invoice.paymentMethod}</TableCell>
            <TableCell className="text-right">{invoice.totalAmount}</TableCell>
          </TableRow>
        ))}
      </TableBody>
      <TableFooter>
        <TableRow>
          <TableCell colSpan={3}>Total</TableCell>
          <TableCell className="text-right">$2,500.00</TableCell>
        </TableRow>
      </TableFooter>
    </Table>
    </Block>)
}


function EquipmentList() {
  const [equipment, setEquipment] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchEquipment = async () => {
      try {
        const response = await fetch('127.0.0.1:8080/api/medtracedev/all');
        if (!response.ok) {
          throw new Error('Failed to fetch equipment');
        }
        const data = await response.json();
        setEquipment(data);
        console.log(response)
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchEquipment();
  }, []);

  if (loading) return <div>Loading equipment...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div>
      <h2>Equipment List</h2>
      <ul>
        {equipment.map((item) => (
          <li key={item.id}>
            {item.name} - {item.year}
          </li>
        ))}
      </ul>
    </div>
  );
}
