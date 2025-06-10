import "../index.css"
import { twMerge } from "tailwind-merge"
import { FiArrowRight, FiMail, FiMapPin} from "react-icons/"
import type { ReactNode } from "react"

function Home() {
    return (
        <>
        

        <div className='min-h-screen bg-zinc-900 px-4 py-12 text-zinc-50'>
            <div className="mx-auto max-w-4xl grid grid-cols-12 gap-4">
                <HeaderBlock></HeaderBlock>
                <Block></Block>
                <Block></Block>
                <Block></Block>
                <Block></Block>
                <Block></Block>
                <Block></Block>
            </div>
        </div>


            
        </>
    )
}

export default Home

// UNDERSTAND WHAT IS GOING ON BELOW

type Props = { // what is type? what is a prop?
    className?: string;   // why do i need this line?
    children?: ReactNode;  // is ? for optional? what is a react node? 
};

const Block = ({ children, className, ...rest } : Props)  => { // what is this doing? is it a for each? is it defining each as a prop?
    return (
        <div className={twMerge("col-span-4 rounded-lg border border-zinc-700 bg-zinc-800 p-6", className )} {...rest}>{children}
</div>
    );
};

const HeaderBlock = () => {
    return <Block className="col-span-12 row-span-2 md:col-span-6 "></Block>
}