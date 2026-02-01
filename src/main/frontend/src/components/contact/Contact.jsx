const Contact = () => {
    return (
        <div className="contact">
            <h1>Contact</h1>
            <form>
                <label htmlFor="fname">First name:</label><br/>
                <input type="text" id="fname" name="fname"/><br/>
                <label htmlFor="lname">Last name:</label><br/>
                <input type="text" id="lname" name="lname"/><br/>
                <label htmlFor="description">Description</label><br/>
                <input type="text" id="description" name="description"/><br/>
            </form>
        </div>
    )
}
export default Contact;