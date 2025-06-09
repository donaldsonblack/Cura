import { Button } from '@/components/ui/button'
import '../index.css'
import { Link } from 'react-router-dom' // using react-router-dom Link rather than <a href=""></a> prevents full page reload
import { Table, TableBody, TableCaption, TableCell, TableFooter, TableHead, TableHeader, TableRow } from '@/components/ui/table'

function Home() {
    return (
        <>
            <h1>Home</h1>
            <div className="flex justify-center flex-wrap items-center gap-2 md:flex-row h-20">
                <Button>
                    <Link to="/">Home</Link>
                </Button>
                <Button>
                    <Link to="/Login">Login</Link>
                </Button>
                <Button>
                    <Link to="/Info">Info</Link>
                </Button>
            </div> 
            
        </>
    )
}

export default Home