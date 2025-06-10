import "../index.css"
import { twMerge } from "tailwind-merge"
import type { ReactNode } from "react"
import { useState, useEffect } from 'react';

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

// Props type definition
type Props = {
    className?: string;   // Optional CSS class name for styling
    children?: ReactNode; // Optional child elements to render inside
};

// Reusable Block component
const Block = ({ children, className, ...rest }: Props) => {
    return (
        <div className={twMerge("h-30 col-span-4 rounded-lg border border-zinc-200 bg-zinc-100 p-6", className)} {...rest}>
            {children}
        </div>
    );
};

function TableBlock() {
  // Changed to array of objects instead of string
  const [data, setData] = useState<any[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string>("");

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/medtracedev/all');
        
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        } 
        
        // Parse as JSON instead of text
        const jsonData = await response.json();
        console.log('Fetched data:', jsonData);
        
        // Set the data (assuming it's an array)
        setData(Array.isArray(jsonData) ? jsonData : []);
        setLoading(false);
      } catch (error) {
        console.error('Fetch error:', error);
        setError("Failed to fetch equipment list.");
        setLoading(false);
      }
    };
    
    fetchData();
  }, []);

  if (loading) {  
    return (
      <Block className="h-max">
        <div className="text-center py-4">Loading...</div>
      </Block>
    );
  }

  if (error) {
    return (
      <Block className="h-max">
        <div className="text-center py-4 text-red-500">{error}</div>
      </Block>
    );
  }

  return (
    <Block className="h-max">
      <Table>
        <TableCaption>Equipment List</TableCaption>
        <TableHeader>
          <TableRow>
            <TableHead>Name</TableHead>
            <TableHead className="text-right">Year</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {data.length > 0 ? (
            data.map((item) => (
              <TableRow key={item.name}>
                <TableCell className="font-medium">{item.name}</TableCell>
                <TableCell className="text-right">{item.year}</TableCell>
              </TableRow>
            ))
          ) : (
            <TableRow>
              <TableCell colSpan={2} className="text-center py-4">
                No equipment data available
              </TableCell>
            </TableRow>
          )}
        </TableBody>
        <TableFooter>
          <TableRow>
            <TableCell>Total Items</TableCell>
            <TableCell className="text-right">{data.length}</TableCell>
          </TableRow>
        </TableFooter>
      </Table>
    </Block>
  );
}

// You'll need to define this component or remove the reference
function EquipmentList() {
  return <div>Equipment List Component</div>;
}