import "../index.css"
import { twMerge } from "tailwind-merge"
import type { ReactNode } from "react"

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
    return <div>Table block</div>;

}

// You'll need to define this component or remove the reference
function EquipmentList() {
  return <div>Equipment List Component</div>;
}